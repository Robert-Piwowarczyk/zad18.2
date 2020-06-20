import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FilteringMachineTest {

    private FilteringMachine machine = new FilteringMachine();

    @Test public void shouldFilterOutNotEvenNumbers() {

        // given
        List<Integer> numberList = new ArrayList<>();
        numberList.add(11);
        numberList.add(92);
        numberList.add(31);
        numberList.add(97);
        numberList.add(61);
        numberList.add(20);
        numberList.add(46);
        numberList.add(14);

        // when
        List<Integer> filteredList = machine.filterOutNotEvenNumbers(numberList);

        // then
        assertThat(filteredList.size(), is(4));
        assertThat(filteredList, hasItem(14));
        assertThat(filteredList, hasItem(46));
    }

    @Test public void shouldFilterOutNumberLowerThan20() {

        // given
        List<Integer> numberList = new ArrayList<>();
        numberList.add(11);
        numberList.add(92);
        numberList.add(31);
        numberList.add(97);
        numberList.add(61);
        numberList.add(20);
        numberList.add(46);
        numberList.add(14);

        // when
        List<Integer> filteredList = machine.filterOutLowerNumbersThan20(numberList);

        // then
        assertThat(filteredList.size(), is(8));
        assertThat(filteredList, hasItem(92));
        assertThat(filteredList, hasItem(97));
        assertThat(filteredList, hasItem(20));
        assertThat(filteredList, hasItem(11));
        assertThat(filteredList, hasItem(31));
        assertThat(filteredList, hasItem(61));
        assertThat(filteredList, hasItem(46));
        assertThat(filteredList, hasItem(14));
    }

    @Test
    public void shouldConvertTitlesToBooks() {
        // given
        List<String> titles = new ArrayList<>();
        titles.add("Doktor Dolittle i jego zwierzęta");
        titles.add("O psie, który jeździł koleją");
        titles.add("Gra dla dzieci z pasją");
        titles.add("Afryka Kazika");
        titles.add("Dziadek i niedźwiadek");

        // when
        List<Book> books = machine.convertToBooks(titles);

        // then
        assertThat(books.size(), is(5));
        assertThat(books, hasItem(new Book("Doktor Dolittle i jego zwierzęta")));
        assertThat(books, hasItem(new Book("O psie, który jeździł koleją")));
        assertThat(books, hasItem(new Book("Gra dla dzieci z pasją")));
        assertThat(books, hasItem(new Book("Afryka Kazika")));
        assertThat(books, hasItem(new Book("Dziadek i niedźwiadek")));
    }

    @Test
    public void shouldConvertTitlesToBooksAndFilterOutStartingWithGra() {
        // given
        List<String> titles = new ArrayList<>();
        titles.add("Doktor Dolittle i jego zwierzęta");
        titles.add("O psie, który jeździł koleją");
        titles.add("Gra dla dzieci z pasją");
        titles.add("Afryka Kazika");
        titles.add("Dziadek i niedźwiadek");

        // when
        List<Book> books = machine.convertToBooksAndReturnOnlyStartingWithGra(titles);

        // then
        assertThat(books.size(), is(1));
        assertThat(books, hasItem(new Book("Gra dla dzieci z pasją")));
    }
}