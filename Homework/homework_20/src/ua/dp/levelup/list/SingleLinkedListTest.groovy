package ua.dp.levelup.list

/**
 * Created by java on 24.01.2017.
 */
class SingleLinkedListTest extends spock.lang.Specification {

    def "Add first Node"() {
        SingleLinkedList list = new SingleLinkedList();

        when: 'add node element'
        list.addFirst(new Node(1));
        //list.addNode(new Node(1), 3);

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
    def "Add Node by index"() {
        SingleLinkedList list = new SingleLinkedList();

        when: 'add node element'
        //list.addFirst(new Node(55));
        list.addNode(new Node(29),0);
        list.addNode(new Node(73),1);
        list.addNode(new Node(88),2);
        list.addNode(new Node(555),1);

        //list.myNode



        then: 'check size'
        //list.size() == 0;
        list.get(0).get().value == 29;
        list.get(1).get().value == 73;
        //list.getFirst().value.next == 90;

        //!list.getFirst().isPresent(); //ifPresent() - метод Optional проверяет есть null или нет

    }
}
