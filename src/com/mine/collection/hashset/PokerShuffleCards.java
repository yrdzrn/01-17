 package com.mine.collection.hashset;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PokerShuffleCards {
	public static void main(String[] args) {
		//准备花色
		ArrayList<String> color = new ArrayList();
		color.add("♠");
		color.add("♥");
		color.add("♣");
		color.add("♦");
		//准备数字，用ArrayList将纸牌从小到大排序
		ArrayList<String> number = new ArrayList<String>();
		for (int i=3; i<=10; i++){
			number.add(i + "");
		}
		number.add("J");
		number.add("Q");
		number.add("K");
		number.add("A");
		number.add("2");
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int index = 0;
		for (String thisnumber: number){
			for (String thiscolor: color){
				map.put(index++, thiscolor+thisnumber);
			}
		}
		//加入大小王
		map.put(index++, "小☻");
		map.put(index++, "大☻");
		//创建内容为0~53的数字集合，代表54张牌
		ArrayList<Integer> cards = new ArrayList<Integer>();
		for (int i=0; i<54; i++){
			cards.add(i);
		}
		//洗牌，使用Collections工具类中的shuffle()方法
		Collections.shuffle(cards);
		ArrayList<Integer> iPlayer = new ArrayList<Integer>();
		ArrayList<Integer> iPlayer2 = new ArrayList<Integer>();
		ArrayList<Integer> iPlayer3 = new ArrayList<Integer>();
		ArrayList<Integer> iSecretCards = new ArrayList<Integer>();
		for (int i=0; i<cards.size(); i++){
			if (i>=51){
				iSecretCards.add(cards.get(i));
			} else{
				if(i%3==0){
					iPlayer.add(cards.get(i));
				} else if (i%3==1){
					iPlayer2.add(cards.get(i));
				} else{
					iPlayer3.add(cards.get(i));
				}
			}
		}
		//对于每个人手中的牌排序，使用Collections工具类的sort()方法
		Collections.sort(iPlayer);
		Collections.sort(iPlayer2);
		Collections.sort(iPlayer3);
		//对应数字形式的每个人手中的牌，定义字符串形式的牌
		ArrayList<String> sPlayer = new ArrayList<String>();
		ArrayList<String> sPlayer2 = new ArrayList<String>();
		ArrayList<String> sPlayer3 = new ArrayList<String>();
		ArrayList<String> sSecretCards = new ArrayList<String>();
		//循环主牌，从map中获取纸牌
		for(Integer key : iPlayer){
			sPlayer.add(map.get(key));
		}
		for(Integer key : iPlayer2){
			sPlayer2.add(map.get(key));
		}
		for(Integer key : iPlayer3){
			sPlayer3.add(map.get(key));
		}
		for(Integer key : iSecretCards){
			sSecretCards.add(map.get(key));
		}
		//看牌
		System.out.println("玩家1：" + sPlayer);
		System.out.println("玩家2：" + sPlayer2);
		System.out.println("玩家3：" + sPlayer3);
		System.out.println("底牌：" + sSecretCards);
	}
}
