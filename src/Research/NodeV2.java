package Research;

/*

 */

public class NodeV2<T1, T2> {

    T1 key;
    T2 value;
    NodeV2<T1, T2> left, right;

    NodeV2(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }
}
