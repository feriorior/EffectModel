import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class IC {
	ReadFileTest rft = new ReadFileTest();
	public int calculate_effct(Vector node) {
		rft.load(".\\links.txt");
		return calculateFrontEffct(node)+calculateBackEffect(node);
	}
	public int calculateFrontEffct(Vector node) {
		rft.load(".\\links.txt");
		HashMap[] map = rft.map_front;
		Vector new_node = (Vector) node.clone();
		int new_node_num = new_node.size();//���˵����Ľڵ�����
		
		while(new_node_num!=0) {
			//Ϊ����������ԣ�ÿ�ν���ڵ����ǰ����������Ҫɾ���Ľڵ����
			Collections.shuffle(new_node);
			for(int i=0 ; i<new_node_num;i++) {
				int current_node = Integer.valueOf(new_node.get(0).toString());
				new_node.remove(0);//�ýڵ�ȡ����ɾȥ
				if(map[current_node].isEmpty()==false) {//�ýڵ�������ӱ�
					Iterator it = map[current_node].entrySet().iterator();
			        while (it.hasNext()) {
			            Map.Entry entry = (Map.Entry) it.next();
			            int key = (int) entry.getKey();
			            double value = (double) entry.getValue();
			            double pr = Math.random();
			            /*
			             * ������ӵĽڵ㲻��node�������Ҽ�����ʴ�����ֵ���ýڵ㼤��
			             * ����node�У�����Ϊ�µĴ�Ⱦ��
			             * 
			             */
			            if( node.contains(key)==false && pr > value) {
			            	node.add(key);
			            	new_node.add(key);
			            }
			        }
				}
			}
			//���ϲ��������һ��time�Ĳ���������ָ���´ε�new_node_num
			new_node_num = new_node.size();
		}
		return node.size();
	}
	public int calculateBackEffect(Vector node) {
		rft.load(".\\links.txt");
		HashMap[] map = rft.map_back;
		Vector new_node = (Vector) node.clone();
		int new_node_num = new_node.size();//���˵����Ľڵ�����
		
		while(new_node_num!=0) {
			//Ϊ����������ԣ�ÿ�ν���ڵ����ǰ����������Ҫɾ���Ľڵ����
			Collections.shuffle(new_node);
			for(int i=0 ; i<new_node_num;i++) {
				int current_node = Integer.valueOf(new_node.get(0).toString());
				new_node.remove(0);//�ýڵ�ȡ����ɾȥ
				if(map[current_node].isEmpty()==false) {//�ýڵ�������ӱ�
					Iterator it = map[current_node].entrySet().iterator();
			        while (it.hasNext()) {
			            Map.Entry entry = (Map.Entry) it.next();
			            int key = (int) entry.getKey();
			            double value = (double) entry.getValue();
			            double pr = Math.random();
			            /*
			             * ������ӵĽڵ㲻��node�������Ҽ�����ʴ�����ֵ���ýڵ㼤��
			             * ����node�У�����Ϊ�µĴ�Ⱦ��
			             * 
			             */
			            if( node.contains(key)==false && pr > value) {
			            	node.add(key);
			            	new_node.add(key);
			            }
			        }
				}
			}
			//���ϲ��������һ��time�Ĳ���������ָ���´ε�new_node_num
			new_node_num = new_node.size();
		}
		return node.size();
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		IC ic = new IC();
		Vector node=new Vector();
		node.add(1);
		int ef = ic.calculateFrontEffct(node);
		System.out.print(ef);
	}

}
