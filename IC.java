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
		int new_node_num = new_node.size();//当此迭代的节点数量
		
		while(new_node_num!=0) {
			//为了增加随机性，每次进入节点操作前，将本次需要删除的节点打乱
			Collections.shuffle(new_node);
			for(int i=0 ; i<new_node_num;i++) {
				int current_node = Integer.valueOf(new_node.get(0).toString());
				new_node.remove(0);//该节点取出后删去
				if(map[current_node].isEmpty()==false) {//该节点具有连接边
					Iterator it = map[current_node].entrySet().iterator();
			        while (it.hasNext()) {
			            Map.Entry entry = (Map.Entry) it.next();
			            int key = (int) entry.getKey();
			            double value = (double) entry.getValue();
			            double pr = Math.random();
			            /*
			             * 如果连接的节点不在node集合中且激活概率大于阈值，该节点激活
			             * 进入node中，并成为新的传染点
			             * 
			             */
			            if( node.contains(key)==false && pr > value) {
			            	node.add(key);
			            	new_node.add(key);
			            }
			        }
				}
			}
			//以上操作完成了一个time的操作，重新指定下次的new_node_num
			new_node_num = new_node.size();
		}
		return node.size();
	}
	public int calculateBackEffect(Vector node) {
		rft.load(".\\links.txt");
		HashMap[] map = rft.map_back;
		Vector new_node = (Vector) node.clone();
		int new_node_num = new_node.size();//当此迭代的节点数量
		
		while(new_node_num!=0) {
			//为了增加随机性，每次进入节点操作前，将本次需要删除的节点打乱
			Collections.shuffle(new_node);
			for(int i=0 ; i<new_node_num;i++) {
				int current_node = Integer.valueOf(new_node.get(0).toString());
				new_node.remove(0);//该节点取出后删去
				if(map[current_node].isEmpty()==false) {//该节点具有连接边
					Iterator it = map[current_node].entrySet().iterator();
			        while (it.hasNext()) {
			            Map.Entry entry = (Map.Entry) it.next();
			            int key = (int) entry.getKey();
			            double value = (double) entry.getValue();
			            double pr = Math.random();
			            /*
			             * 如果连接的节点不在node集合中且激活概率大于阈值，该节点激活
			             * 进入node中，并成为新的传染点
			             * 
			             */
			            if( node.contains(key)==false && pr > value) {
			            	node.add(key);
			            	new_node.add(key);
			            }
			        }
				}
			}
			//以上操作完成了一个time的操作，重新指定下次的new_node_num
			new_node_num = new_node.size();
		}
		return node.size();
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		IC ic = new IC();
		Vector node=new Vector();
		node.add(1);
		int ef = ic.calculateFrontEffct(node);
		System.out.print(ef);
	}

}
