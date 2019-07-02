import java.util.ArrayList;
import java.util.List;

public class MyNode {
    private MyNode leftNode;
    private MyNode rightNode;
    private Object value;

    public void add (Object v) {
        if (null == value)
            this.value = v;
        else {
            if ((Integer) v  - (Integer) this.value <= 0) {
                if (null == this.leftNode) {
                    this.leftNode = new MyNode();
                }
                this.leftNode.add(v);
            }
            else{
                if (null == this.rightNode) {
                    this.rightNode = new MyNode();
                }
                this.rightNode.add(v);
            }
        }
    }

    public List<Object> values () {
        List<Object> values = new ArrayList<>();
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
