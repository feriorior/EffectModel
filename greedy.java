import java.util.HashMap;
import java.util.Vector;

public class greedy {

	public Vector forward(){
		// TODO 自动生成的方法存根
		IC ic = new IC();
		/*
		 * 正向影响力计算
		 */
		int k = 10;//十个节点
		int iter = 0;
		//每次挑选一个10节点，选择5000次中最优
		Vector best_vec = new Vector();
		int best_score = 0;
		while(iter<1) {//目前只循环一次的说
			iter++;
			System.out.println("iter"+iter);
			Vector init = new Vector();
			for(int i = 0 ; i < k ; i++) {
				System.out.println("第"+i+"个点");
				int best_index = -1;
				int best_ef = -1;
				for(int j = 0 ; j < 20 ; j++) {
					if(init.contains(j)==false) {
						
						/*
						 * 需要使用深拷贝的数组代替进入，否则会导致问题
						 */
						Vector a = new Vector();
						Vector b = new Vector();
						for(int p = 0 ;p < init.size() ;p++) {
							a.add(init.get(p));
							b.add(init.get(p));
						}
						b.add(j);
						int j_ef = ic.calculateFrontEffct(b)-ic.calculateFrontEffct(a);
						if(j_ef>best_ef) {
							best_index = j;
							best_score = j_ef;
						}
					}
				}
				init.add(best_index);
			}
			Vector c = new Vector();
			for(int i = 0 ; i < init.size() ; i++) {
				c.add(init.get(i));
			}
			if(ic.calculateFrontEffct(c) > best_score) {
				best_score = ic.calculate_effct(c);
				best_vec = init;
			}
		}		
		return best_vec;
	}
	
	public static void main(String[] args) {
		greedy gd = new greedy();
		Vector best_front = new Vector();
		best_front = gd.forward();
		System.out.println("前向影响力");
		for(int i = 0 ; i < best_front.size() ; i++) {
			System.out.print(best_front.get(i)+"    ");
		}
		System.out.println();
		
		
	}
}
