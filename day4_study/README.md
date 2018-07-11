◇ 조합탐색
  - 최적해가 될 가능성이 없는 답을 미리 알아내 방지하여, 탐색공간을 줄이는 방법
  - 유한한 크기의 탐색공간을 뒤지면서 답을 찾아내는 알고리즘

  - 최적화 기법[TSP 적용]
  1) 가지치기 (pruning)
    = 현재 상태가 best보다 나쁘다면, 더 진행하지 않는다.(잘라낸다.)
  2) 간단한 휴리스틱으로 적당한 값 찾기 [optimistic heuristic]
    - 추정이기 때문에 (resturn 값 <=남은 최단 길이) 여야 인정한다.
    = 가장 짧은 간선의 길이 더하기
    = 가장 가까운 정점부터 방문하기
  3) 지나온 경로 검토하기 [경로순서 바꾸기]
    = a,d의 경로를 a-b-c-d 에서 a-c-b-d로 바꿔서 후자가 짧다면, 전자에 대한 탐색 중단.
  4) MST(Minimum Spanning Tree)를 이용한 휴리스틱 
    -MST : 노드간 연결성을 보장하며, 비용을 최소로하는 그래프
    =MST 찾기에는, 크루스칼과 프림알고리즘 사용
    -크루스칼 : 비용이 최소인 간선을 고르고, 연결되어 있지 않으면 연결시킨다. 이 방법을 모든 엣지에 적용한다.
    -프림 : 말단 정점 중에서 가장 비용이 작은 간선을 선택하여, 연결되어 있지 않으면 연결시킨다.
  5) 메모이제이션 
    =남은 도시(<=5)가 얼마 없을 때 쓴다. (개수 클수록 메모리↑↑)
    
  * 최적화 > 결정문제로 바꾸기 
    - ex) best_length와 비교하여 진행여부를 결정하는 방법
  * TSP의 예로 쓰지만 적용했을 때의 효율성을 바로 알 수 없기 때문에, 마지막까지 미뤄두는 편.
  (보통은 TSP만을 해결하기 위한 정수, 선형계획법을 쓴다.)
  
-https://ratsgo.github.io/data%20structure&algorithm/2017/11/28/MST/
-http://peung.tistory.com/8
-http://blog.naver.com/PostView.nhn?blogId=manonflame&logNo=220921065963&parentCategoryNo=&categoryNo=14&viewDate=&isShowPopularPosts=true&from=search
-http://pastoffuture.tistory.com/entry/11%EC%9E%A5-%EC%A1%B0%ED%95%A9-%ED%83%90%EC%83%89-12
-http://ezwy.tistory.com/352

◇ 이진탐색트리'
  - 이진탐색(binary search)과 연결리스트(linked list)를 결합한 자료구조의 일종
  - 이진탐색 : 계산복잡성은 O(logn)으로 빠르지만 자료 입력, 삭제가 불가능. 
  - 연결리스트 : 자료입력, 삭제는 O(1)이나 탐색은 O(n)
  - 순회방식은 중위순회 (좌 근 우)

  -핵심연산 (검색, 삽입, 삭제) +이진트리 생성, 삭제 + 확인, 트리순회
  1) 검색 - 높이 h에 대해서 O(h)
  2) 삽입 - 검색연산과 같음 O(h)
  3) 삭제  
    - 자식노드가 없는 경우 > 그냥 삭제
    - 자식노드가 1개 >  삭제후 해당 자식노드를 연결
    - 자식노드가 2개 > 삭제노드의 자식 중왼쪽 최대값(predecessor), 오른쪽 최소값(successor)
         > 중위순회방식으로 나열했을 때 삭제노드 왼쪽, 오른쪽 값이 된다.
         > 이진탐색트리 구조 상 successor은 자식노드가 1개 이하다.
         = 삭제할 노드에 predecessor 혹은 successor의 값을 복사하여 입력, 복사한 값은 자식이 0~1개 이므로 삭제한다.
  한계점 : 최악의 경우 노드개수만큼의 높이가 생성될 수 있다. 이러면 계산복잡성(n) > 전체균형을 맞추는 AVL Tree 등장

-AVL tree : 핵심은 Balanced Factor(BF)
  - BF = (왼쪽 서브트리 높이 -오른쪽 서브트리 높이)(같으면 0) 
  - 값을 삽입/삭제 과정에서 BF값에 따라 서브트리를 재구성(-이를 rotation이라 부른다.)
  - 값이 입력되었을때 왼/오 높이 차이가 2이상이면 서브트리 재구성
  
  1)single rotaion
    -한쪽 서브트리가 더 무거운 경우, 해당 자식노드를 root로 이동시킨다.(값들이 회전하듯이 이동한다.)
    -이 행동을 1번 수행하는 것이 single rotation
    -왼쪽이 무거울때 오른쪽 회전(오른쪽에 있는 자식과 부모바꾸기)
    / 오른쪽이 무거울때 왼쪽 회전(부모의 왼쪽에 있는 자식과 부모바꾸기)
      -조건[ 근{좌}{우}
    -U {V{새노드}{} }{W}    -> 오른쪽 회전
    -U {V{}{}}{W{}{새노드}} -> 왼쪽 회전
    
  2)double rotaion 
      -조건
    -U {V {}{A새노드}} {W} 
      ->A를 중심으로 l회전, A중심으로 r회전 
    
    -U {V} {W{B새노드}{}}   
      ->B를 중심으로 r회전, B중심으로 l회전
      
  3)시나리오별 rotation
  - U {V {A}{B}}{W {C}{D}}
    -A : single right rotation
    -B : double rotaion(left-right)
    -C : double rotation(right-left)
    -D : single left rotation
  
  4)삽입/삭제 -> 재구성 후에 중위탐색(좌근우)로 읽은 결과가 
  오름차순을 만족하는 것을 확인한다.
  
  5)계산복잡성 
  -삽입 : 높이 h일때 O(h)
    -BF 계산대상 (새잎새~root)의 모든 경로 ->O(h)
    -rotation연산 - 부모자식관계만 변경 -> O(1)
    -> BF 계산 + rotation연산을 고려하여 O(h)
  -삭제 : O(h)
    -삭제 후 BF계산
    -BF가 차이나는 노드에 대해 rotation 수행하는
    -> BF계산, rotation 을 고려하여 O(h)
  -높이 h에 의존적, 트리노드수가 n개라면 h는 2log2 n 이상
  - O(h) = O(logn) > O(n)인 이진탐색트리보다 낮다.

-https://ratsgo.github.io/data%20structure&algorithm/2017/10/22/bst/