package HuffmanCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCode {
	static HuffmanNode root;
	static Map<Character, String> charBinaryMapping = new HashMap<Character, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABBCCCCGGGGDEAAAEDBBBDFAGG";
		String code = encode(str);
		System.out.println("Final code: "+ code);
	}

	private static String encode(String str) {
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (frequency.get(str.charAt(i)) == null)
				frequency.put(str.charAt(i), 1);
			else
				frequency.put(str.charAt(i), frequency.get(str.charAt(i)) + 1);
		}
		HuffmanNode root = generateTree(frequency);
		setBinaryCode(root, new StringBuilder());
		System.out.println("Binary Code: " + charBinaryMapping);
		StringBuilder s = new StringBuilder();
		for(int i=0; i<str.length();i++)
		{
			char c = str.charAt(i);
			s.append(charBinaryMapping.get(c));
		}
		return s.toString();
	}

	private static void setBinaryCode(HuffmanNode node, StringBuilder sb) {
		if (node != null) {
			if (node.left == null && node.right == null) {
				charBinaryMapping.put(node.data, sb.toString());
			} else {
				sb.append('0');
				setBinaryCode(node.left, sb);
				sb.deleteCharAt(sb.length() - 1);
				sb.append('1');
				setBinaryCode(node.right, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	private static HuffmanNode generateTree(Map<Character, Integer> frequency) {
		PriorityQueue<HuffmanNode> priorityQ = new PriorityQueue<>();
		Set<Character> keySet = frequency.keySet();
		//import node
		for (Character character : keySet) {
			HuffmanNode node = new HuffmanNode();
			node.data = character;
			node.freq = frequency.get(character);
			node.left = null;
			node.right = null;
			priorityQ.offer(node);
		}
		//merge two first node in the queue and continue
		while (priorityQ.size() > 1) {
			HuffmanNode first = priorityQ.peek();
			priorityQ.poll();
			HuffmanNode second = priorityQ.peek();
			priorityQ.poll();
			HuffmanNode mergeNode = new HuffmanNode();
			mergeNode.left = first;
			mergeNode.right = second;
			mergeNode.freq = first.freq + second.freq;
			mergeNode.data = '-';
			root = mergeNode;
			priorityQ.add(mergeNode);
		}
		return priorityQ.poll();
	}

}

class HuffmanNode implements Comparable<HuffmanNode> {
	int freq;
	char data;
	HuffmanNode left, right;

	@Override
	public int compareTo(HuffmanNode o) {
		return freq - o.freq;
	}
}
