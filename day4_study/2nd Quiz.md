https://www.acmicpc.net/problem/1827

여행가이드 

윤화의 직장은 여행을 온 사람들을 버스에서 안내하는 여행 가이드이다. 윤화는 어느 날 다른 날과 다름없이 N명의 사람을 버스 안에서 인솔을 하게 되었다.

그러던 도중 점심시간을 갖게 되었다. 점심시간은 한 시간인데 그 시간동안에는 N명의 사람들은 각자 자기가 가고 싶은 곳으로 갈 수 있다. 한 시간 뒤에 사람들을 버스에서 모이기로 약속을 하고 모두 흩어졌다.

그런데 일이 발생하고 말았다. 한 시간이 흘렀는데 사람들이 아무도 버스에 돌아오지 않은 것이다. 윤화는 흩어진 사람들을 모두 만나서 빨리 버스로 돌아가라고 말을 해 주고 버스로 돌아가야 한다. (단, 그 말을 들은 사람은 그 즉시 자신의 이동 방향을 바꾸어 버스를 향해 이동한다고 가정하여도 좋다.) 그런데 최대한 여행 일정이 늦어지지 않게 하기 위해서 마지막에 버스에 도착하는 사람의 시간을 최소로 하려 한다.

당신이 가지고 있는 정보는 다음과 같다. 점심시간이 끝나는 시각에 N명의 사람들의 위치의 좌표, 그리고 그 사람들의 이동 속도, 그리고 그 사람이 현재 이동하고 있는 방향이 주어진다. (모든 사람은 직선으로만 이동을 한다)




입력
 

첫째 줄에는 사람의 수 N(1≤N≤8)이 주어진다. 그리고 두 번째 줄에는 당신의 이동 속도가 소수로 주어진다. 그리고 세 번째 줄부터 N+2번째 줄 까지 네 개의 소수 xi,yi,vi,ai가 차례로 주어진다.  (xi, y1) (-10^6 <=xi,yi<= 10^6)는 점심시간이 끝났을 때 i번째 사람의 좌표를 의미하고, vi(1≤vi≤100)는 i번째 사람의 이동 속도를 의미한다. 그리고 ai(1≤ai≤2파이) 는 그 사람의 이동 방향을 의미한다.




출력
 

마지막 사람이 도착하는 시간을 소수점 첫째 자리에서 반올림하여 정수로 출력하시오.






예제 입력
3
100.0
40.0 25.0 20.0 5.95
-185.0 195.0 6.0 2.35
30.0 -80.0 23.0 2.76




예제 출력
 51
