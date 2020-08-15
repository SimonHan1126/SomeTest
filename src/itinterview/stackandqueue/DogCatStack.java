package itinterview.stackandqueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author hanshihui
 * Created by hanshihui on 2017/12/9.
 */
public class  DogCatStack {

    private Queue<Pet> dogQueue = new ArrayBlockingQueue<>(100);
    private Queue<Pet> catQueue = new ArrayBlockingQueue<>(100);

    public void add(Pet pet)
    {
        if(pet instanceof Dog)
        {
            dogQueue.add(pet);
            catQueue.add(null);
        }
        else
        {
            dogQueue.add(null);
            catQueue.add(pet);
        }
    }

    public void pollAll()
    {
        while (!dogQueue.isEmpty() && !catQueue.isEmpty())
        {
            Pet pet = dogQueue.poll();
            if(pet == null)
            {
                pet = catQueue.poll();
            }
        }
    }

    public void pollDog()
    {

    }

    public void pollCat()
    {

    }

    public boolean isEmpty()
    {

        return false;
    }

    public boolean isEmptyCat()
    {

        return false;
    }

    public boolean isEmptyDog()
    {

        return false;
    }

    public static void main(String[] args) {

    }
}

class Pet {

    private String type;



    public Pet(String type) {

        this.type = type;

    }

    public String getPetType() {

        return this.type;

    }

}

class Dog extends Pet {



    public Dog() {

        super("dog");

    }

}



class Cat extends Pet {



    public Cat() {

        super("cat");

    }

}

