package chapter8;

public class SizeStatus implements DeckObserver {
    @Override
    public void sizeChange(int size) {
        System.out.println(size);
    }

    @Override
    public void sizeChange(DataModel pModel) {
        System.out.println(pModel.sizeChange());
    }
}
