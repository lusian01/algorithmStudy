#gitignore
gitignore이란 github에 해당 확장자 file들을 등록되는 것을 방지하기 위해 사용
흔히 .project 와 같은 file들을 방지할 때 많이 사용한다.

#gitignore 설정 방법
  // .gitignore 파일을 생성한다.
  $ touch .gitignore
  // .gitignore은 숨김 파일이므로 아래의 2가지 방법으로 제대로 생성됐는지를 확인한다.
  $ la
  $ ls -a
  // .gitignore 파일을 수정한다.
  $ vi .gitignore


gitignore 내용 추가 후 git push
// 현재 Repository의 cache를 모두 삭제한다.
$ git rm -r --cached .

// [File Name]에 해당하는 파일을 원격 저장소에서 삭제한다.
// (로컬 저장소에 있는 파일은 삭제하지 않는다.)
$ git rm -r --cached [File Name]
// .gitignore에 넣은 파일 목록들을 제외하고 다른 모든 파일을 다시 track하도록 설정한다.
$ git add .
$ git commit -m "Fixed untracked files"

