
import containers.ContainerHistory;
import containers.ProductContainer;
import containers.ProductContainerRecorder;

public class Main {

    public static void main(String[] args) {
// the well known way:
ProductContainerRecorder mtv = new ProductContainerRecorder("kahvi",10,5);
        System.out.println(mtv.takeFromTheContainer(7));
    }

}




