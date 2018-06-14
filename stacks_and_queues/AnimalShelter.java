import java.util.*;

class AnimalShelter {
	public static void main(String[] args) {
		AnimalQueue animalQ = new AnimalQueue();
		animalQ.enqueue(new Cat("Oliver"));
		animalQ.enqueue(new Dog("Bolt"));
		animalQ.enqueue(new Cat("Simba"));
		animalQ.enqueue(new Dog("Goofy"));
		animalQ.enqueue(new Cat("Tigger"));
		animalQ.enqueue(new Dog("Pluto"));
		System.out.println(animalQ.dequeueAny().getName());
		System.out.println(animalQ.dequeueCat().getName());
		System.out.println(animalQ.dequeueAny().getName());
		System.out.println(animalQ.dequeueAny().getName());
		System.out.println(animalQ.dequeueDog().getName());
		System.out.println(animalQ.dequeueAny().getName());
	}
}

abstract class Pet {
	private String name;
	private int order;
	private static int cnt = 0;
	public Pet(String name) {
		this.name = name;
		this.order = cnt;
		cnt++;
	}

	public String getName() {
		return name;
	}

	public int getOrder() {
		return order;
	}
}

class Cat extends Pet {
	public Cat(String name) {
		super(name);
	}
}

class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}
}

class AnimalQueue {
	private LinkedList<Dog> dogQ = new LinkedList<>();
	private LinkedList<Cat> catQ = new LinkedList<>();

	public void enqueue(Dog dog) {
		dogQ.add(dog);
	}

	public void enqueue(Cat cat) {
		catQ.add(cat);
	}

	public Pet dequeueAny() {
		if (catQ.isEmpty()) {
			return dogQ.pollFirst();
		} else if (dogQ.isEmpty()) {
			return catQ.pollFirst();
		}
		return catQ.peekFirst().getOrder() < dogQ.peekFirst().getOrder() ? catQ.pollFirst() : dogQ.pollFirst();
	}

	public Dog dequeueDog() {
		return dogQ.pollFirst();
	}

	public Cat dequeueCat() {
		return catQ.pollFirst();
	}
}
