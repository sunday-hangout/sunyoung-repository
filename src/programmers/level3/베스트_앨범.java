package programmers.level3;

// https://programmers.co.kr/learn/courses/30/lessons/42579

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class 베스트_앨범 {

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, List<Song>> genresMap = new HashMap<>(); // 장르별 노래 구분
        Map<String, Integer> total = new HashMap<>(); // 장르별 총합

        // 1. 가장 인기가 많은 장르 순서대로 나열
        for(int i=0; i<genres.length; i++){

            Song song = new Song();

            song.num = i;
            song.play = plays[i];


            if(total.containsKey(genres[i])){
                total.replace(genres[i], total.get(genres[i]) + plays[i]); // 장르별 총합 더하기

                genresMap.get(genres[i]).add(song);
            }
            else{
                List<Song> firstList = new ArrayList<>();
                firstList.add(song);

                total.put(genres[i], plays[i]); // 총합
                genresMap.put(genres[i], firstList);
            }
        }

        List<String> genresList = new ArrayList<>(total.keySet());

        Collections.sort(genresList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return total.get(o2).compareTo(total.get(o1));
            }
        });

        // 2. 장르별 노래 play 순서대로 정렬
        Comparator<Song> songComparator = new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o2.play - o1.play;
            }
        };

        for(String key : genresList){
            genresMap.get(key).sort(songComparator);
        }

        // 3. 장르 중에 가장 재생횟수가 많은 순서대로 2개 추가
        for(String key : genresList){

            answer.add(genresMap.get(key).get(0).num);

            if(genresMap.get(key).size() > 1){
                answer.add(genresMap.get(key).get(1).num);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }


    @Test
    public void 정답(){
        Assert.assertArrayEquals(new int[]{4, 1, 3, 0}, solution(new String[]{"classic", "pop", "classic", "classic", "pop"	}, new int[]{500, 600, 150, 800, 2500}));

    }
}

class Song{
    public int num; // 고유번호
    public int play; // 재생횟수
}

