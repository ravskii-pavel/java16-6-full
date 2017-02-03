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
        list.addNode(new Node(99),3);
        list.addNode(new Node(111),4);
        list.addNode(new Node(222),5);
        list.addNode(new Node(333),6);
        list.addNode(new Node(555),3);
        list.addFirst(new Node("first Node"));
        list.addLast(new Node("last Node"));
        list.removeNode(5);

        //list.myNode

        then: 'check nodes'
        list.get(0).get().value == "first Node";
        list.get(1).get().value == 29;
        list.get(2).get().value == 73;
        list.get(3).get().value == 88;
        list.get(4).get().value == 555;
        //list.get(5).get().value == 99;
        list.get(5).get().value == 111;
        list.get(6).get().value == 222;
        list.get(7).get().value == 333;
        list.get(8).get().value == "last Node";
        //!list.getFirst().isPresent(); //ifPresent() - метод Optional проверяет есть null или нет

    }
}
