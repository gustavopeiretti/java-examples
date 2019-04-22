package j11;

public class Outer {

    public void outerPublic() {
    }

    private void outerPrivate() {
    }

    class Inner {

        public void innerPublic() {
            outerPrivate();
        }
    }


}



