package com.self.programmers;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

public class Genres {

	public int[] solution(String genres[], int[] plays) {
		Map<String, List<Song>> genreSongs = new HashMap<>();
		//genre별 list add
		for(int i=0; i<genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];
			if(!genreSongs.containsKey(genre)) {
				List<Song> list = new ArrayList<Song>();
				genreSongs.put(genre, list);
			}
			genreSongs.get(genre).add(new Song(i, genre, play));
		}
		
		//genre별 플레이수 합
		Map<String, Integer> playSumByGenre = new HashMap<String, Integer>();
		List<Integer> rankedPlays = new ArrayList<Integer>();
		for(String genre : genreSongs.keySet()) {
			int playsSum = genreSongs.get(genre).stream().mapToInt(Song::getPlay).sum();
			playSumByGenre.put(genre, playsSum);
			rankedPlays.add(playsSum);
		}
		Collections.sort(rankedPlays, Collections.reverseOrder());

		//rank 1위, 2위 genre 선정
		String rankedGenres[] = new String[genreSongs.keySet().size()];
		int rankIndex=0;
		
		for(int i : rankedPlays) {
			for(String genre : playSumByGenre.keySet()) {
				if(playSumByGenre.get(genre).equals(i)) { 	//1위
					playSumByGenre.remove(genre, playSumByGenre.get(genre));	//같은게 있을수 있으니 제거
					rankedGenres[rankIndex] = genre;
					rankIndex++;
					break;
				}
			}
		}

		//genre별 list  play수로 reverse Order
		List<Integer> resultList = new ArrayList<Integer>();
		for(int i=0; i<rankedGenres.length; i++) { 	//장르 1,2위 선택
			String genre = rankedGenres[i];
			for(int j=0; j<2; j++) {//장르별 리스트 1,2위 선택
				List<Song> genreList = genreSongs.get(genre);
				if(j==1 && genreList.size() ==1) {	//장르가 하나면 break;
					break;
				}
				Collections.sort(genreSongs.get(genre), Comparator.comparingInt(s->((Song) s).getPlay()).reversed()); 	//장르별 리스트 reverseOrder
				resultList.add(genreList.get(j).getIndex());
			}
		}
		
		int[] answer = new int[resultList.size()];
		for(int i=0; i<resultList.size(); i++) {
			answer[i] = resultList.get(i);
		}
		
		return answer;
	}
	
	@Test
	public void test() {


		Genres g = new Genres();
//		Assert.assertEquals(new int[]{4,1,3,0}, g.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
		String[] genres = {
				"aaa"
				,"bbb"
				,"ccc"
				,"ddd"
				,"ddd"
				,"eee"
				};

				int[] plays = {
				 200
				,500
				,100
				,300
				,400
				,500
				};
		Assert.assertEquals(new int[]{3, 4, 1, 5, 0, 5}, g.solution(genres, plays));
	}
	
	public static void main(String[] args) {
		Genres g = new Genres();
//		Assert.assertEquals(new int[]{4,1,3,0}, g.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
		String[] genres = {"aaa"
				,"aaa"
				,"aaa"
				,"ccc"
				,"ccc"
				,"ddd"
				,"eee"
				,"rrr"
				,"rrr"
				,"rrr"
				,"rrr"
		};
		
		int[] plays = {500
				,200
				,100
				,100
				,350
				,400
				,600
				,10
				,20
				,600
				,200
		};
		Assert.assertEquals(new int[]{9, 10, 0, 1, 6, 4, 3, 5}, g.solution(genres, plays));
	
	}
}

class Song{
	private int index;
	private String genre;
	private int play;
	public Song(int index, String genre, int play) {
		this.index = index;
		this.genre = genre;
		this.play = play;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPlay() {
		return play;
	}
	public void setPlay(int play) {
		this.play = play;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return index + genre + play;
	}
}
