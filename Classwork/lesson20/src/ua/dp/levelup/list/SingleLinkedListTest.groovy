package ua.dp.levelup.list

/**
 * Created by java on 24.01.2017.
 */
class SingleLinkedListTest extends spock.lang.Specification {

    def "Add first Node"() {
        SingleLinkedList list = new SingleLinkedList();

        when: 'add node element'
        list.addFirst(new Node(1));

        then: 'check size'
        list.size() == 1;
        list.getFirst().isPresent(); //ifPresent() - метод Optional проверяет есть null или нет
        list.getFirst().get().value == 1;

    }

    def "Add null nod to empty list"() {
        SingleLinkedList list = new SingleLinkedList();

        when: 'add node element'
        list.addFirst(null);

        then: 'check size'
        list.size() == 0;
        !list.getFirst().isPresent(); //ifPresent() - метод Optional проверяет есть null или нет

    }
}
