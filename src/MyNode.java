import java.util.ArrayList;
import java.util.List;

public class MyNode<T extends Comparable<T>> {
    private MyNode<T> leftNode;
    private MyNode<T> rightNode;
    private T value;

    public void add (T v) {
        if (null == value)
            this.value = v;
        else {
            if (v.compareTo(this.value) <= 0) {
                if (null == this.leftNode) {
                    this.leftNode = new MyNode<T>();
                }
                this.leftNode.add(v);
            }
            else{
                if (null == this.rightNode) {
                    this.rightNode = new MyNode<T>();
                }
                this.rightNode.add(v);
            }
        }
    }

    public List<T> values () {
        List<T> values = new ArrayList<>();
        if (null != this.leftNode) {
            values.addAll(this.leftNode.values());
        }
        values.add(this.value);
        if (null != this.rightNode) {
            values.addAll(this.rightNode.values());
        }
        return values;
    }
}
