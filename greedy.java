import java.util.HashMap;
import java.util.Vector;

public class greedy {

	public Vector forward(){
		// TODO �Զ����ɵķ������
		IC ic = new IC();
		/*
		 * ����Ӱ��������
		 */
		int k = 10;//ʮ���ڵ�
		int iter = 0;
		//ÿ����ѡһ��10�ڵ㣬ѡ��5000��������
		Vector best_vec = new Vector();
		int best_score = 0;
		while(iter<1) {//Ŀǰֻѭ��һ�ε�˵
			iter++;
			System.out.println("iter"+iter);
			Vector init = new Vector();
			for(int i = 0 ; i < k ; i++) {
				System.out.println("��"+i+"����");
				int best_index = -1;
				int best_ef = -1;
				for(int j = 0 ; j < 20 ; j++) {
					if(init.contains(j)==false) {
						
						/*
						 * ��Ҫʹ����������������룬����ᵼ������
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
		System.out.println("ǰ��Ӱ����");
		for(int i = 0 ; i < best_front.size() ; i++) {
			System.out.print(best_front.get(i)+"    ");
		}
		System.out.println();
		
		
	}
}
