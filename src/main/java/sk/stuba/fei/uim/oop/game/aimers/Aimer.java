package sk.stuba.fei.uim.oop.game.aimers;

public class Aimer {
    private boolean[] aimArray;
    public Aimer(){
        aimArray = new boolean[6];
    }

    public boolean addAimerAt(int index) throws IndexOutOfBoundsException{
        if(aimArray[index]){
            System.out.println("There is already aimer on this position!");
            return false;
        }
        System.out.println("Succesfully added aimer at position " + (index+1));
        aimArray[index] = true;
        return true;
    }

    public void removeAimAt(int index) throws IndexOutOfBoundsException{
        aimArray[index] = false;
    }
    public boolean isAimingAt(int index){
        return aimArray[index];
    }
}
