package d2014_3.q3;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 16:40
 * ���Ʊ���ԭ���ʷ�����
 * nextLine��ȡ��һ�У��ո�Ҳ�������롣����Ҫ��֮ǰ��һ��nextLine����ȡ��һ��nextIntδ��ȡ�Ļ���
 * List����ֱ��ʹ��Collections.Sort()������
 * ��Set������Ż�Ҫ��д�ȽϷ���̫�鷳������ֱ����TreeMap�����������Ƚϣ������򣩻�Map�����м�Ϊ���ţ�ֵΪ��������
 * @author PengCheng
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Main().run();
	}
	
	public void run() {
		readOptionsString();
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		// !!!!!!!��Ҫ��ȡһ���س�
		input.nextLine();
		for(int i=0; i<num; i++) {
			String command = input.nextLine();
			process(command, i);
		}
	}
	
	public final static int NO_PARAM = 0;
	public final static int PARAM = 1;
	/*
	 *  key�Ƿ���
	 *  valueΪ0��ʾ�޲Σ�Ϊ1��ʾ����
	 */
	Map<Character, Integer> options;
	
	/**
	 *  ��ȡ��ʽ�ַ���
	 *  ����һ��ʹ��split(":")������ַ�������ÿ�����ַ����������һλ���뺬��ѡ���б��������ķ����޲�ѡ���б�
	 *         �����Ὣ�ַ������һλѡ����Զ��Ϊ��ð�ŵ�ѡ������������һ���ַ����ж�һ�Ρ�
	 *  ��������Ҳ�����������ַ���ƥ��ķ���������һ��ָ���������ַ�������ÿһ���ַ������������
	 *          1��Ϊ������  2��Ϊ��ĸ����һ����ĸ��Ϊ������ 3��Ϊ��ĸ����һ����ĸΪ������
	 */
	public void readOptionsString() {
		options = new HashMap<Character, Integer>();
		Scanner input = new Scanner(System.in);
		String optionsString = input.next();
		
		for(int pos=0; pos<optionsString.length(); pos++) {
			char c = optionsString.charAt(pos);
			
			// next���ܻ�ȡ����
			char next = 'a';
			if(pos<optionsString.length()-1) {
			    next = optionsString.charAt(pos+1);
			}
			if(':'== next) {
				options.put(c, PARAM);
				pos++;
			} else {
				options.put(c, NO_PARAM);
			}
		}
		
	}
	
	/**
	 *  ��������д���
	 *  ע�����ΪСд��ĸ�����ֺͼ�����ɵķǿ��ַ���
	 * @param s  Ҫ����������
	 */
	public void process(String s, int order) {
		System.out.print("Case " + order + ": ");
		
		// words[0] Ϊ�����������ش���
		String[] words = s.split(" ", 2);
		if(words.length<2) return;
		s = words[1];

		List<String> optionsList = new ArrayList<String>();
//		Map<String, Integer> times = new HashMap();
//		for(Character key: options.keySet()) {
//			times.put(key, 0);
//		}
		
		
		int pos = 0;
	    while(pos<s.length()) {
	    	char now = s.charAt(pos);
	    	StringBuilder option = new StringBuilder();
	    	if(now==' ') {
	    		pos++;
	    		continue;
	    	} else if('-' == now) {
	    		option.append("-");
	    		pos++;
	    		now = s.charAt(pos);
	    		if(options.containsKey(now)) {
	    			// �޲�ѡ��
	    			if(options.get(now) == NO_PARAM) {
	    				option.append(now);
	    				pos++;
	    			} else { // ����ѡ��
	    				option.append(now+" ");
	    				pos++;
	    				now = s.charAt(pos);
	    				// ����ѡ��Ͳ���֮��Ŀո�
	    				while(now==' ') {
	    					pos++;
	    					now = s.charAt(pos);
	    				}
	    				
	    				// ��Ŀ�л�˵�С�-��������
	    				int l = s.length();
	    				while((now>='a' && now<='z')
	    						||(now>='0' && now<='9')
	    						||now=='-') {
	    					option.append(now);
	    					pos++;
	    					if(pos>=l) {
	    						break;
	    					}
	    					now = s.charAt(pos);
	    				}
	    				
	    			}
	    			//option.append(" ");
	    			optionsList.add(option.toString());
	    		} else {
	    			break;
	    		}
	    	} else {
	    		break;
	    	}
	    }

    	Collections.sort(optionsList);
    	for(int i=0; i<optionsList.size()-1; i++) {
    		String ooo = optionsList.get(i);
    		String ooo2 = optionsList.get(i+1);
    		ooo = ooo.substring(0, 2);
    		ooo2 = ooo2.substring(0, 2);
    		if(ooo.equals(ooo2)) {
    			optionsList.remove(i);
    		}   		
    	}
    	
    	for(String sss: optionsList) {
    		System.out.print(sss+" ");
    	}
    	System.out.println();
		
		
	}

}