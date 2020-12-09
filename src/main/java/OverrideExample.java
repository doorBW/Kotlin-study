abstract class AbstractBase {
    abstract void parentFunction();
    final void notOverrideFunction(){};
}

public class OverrideExample extends AbstractBase{

    @Override
    void parentFunction() {

    }

//    @Override
//    void notOverrideFunction(){ // error
//
//    }
}

class TwiceOverrideExample extends OverrideExample{

}
