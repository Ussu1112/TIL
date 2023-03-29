
git 명령어
====


작업 로그 (git log)
----
>git log - 커밋 제목 커밋 내용과 함께 해시 값이 같이 출력된다.  
git log --oneline - git log를 짧은 커밋 메세지로 출력한다 (커밋당 한 줄) 해시는 전체 해시 값 중 앞 7글자가 출력된다.

<br>

작업 비교하기 (git diff)
----

>git diff - 최근 커밋과 작업 디렉터리 비교하기  
git diff --staged - 최근 커밋과 스테이지 비교하기 ( git add 후 )  
git diff <커밋(기준)> <커밋> - 커밋끼리 비교하기 (git diff <이 커밋에 비해> < 이 커밋은 뭐가 다른가? >)

<br>

작업 되돌리기 ( revert, reset )
----

revert - 버전을 되돌린 새로운 버전을 만들기   
현재 까지 있는 버전을 유지 한 채 되돌린 버전을 새로운 버전으로 생성

> git revert <취소할 커밋>
-> <취소할 커밋> 이 취소된 새로운 커밋 만들기  

기존 작업 내용(git log)가 그대로 유지되며 작업을 되돌린다




<br>

reset - 버전을 완전히 되돌리기

하나의 버전이 만들어지는 과정  
1. 작업 디렉터리에서 변경 사항 생성하기 ( hard reset )
-> 작업 디렉터리까지 되돌리기
2. 스테이지로 추가하기 ( mixed reset )
-> 스테이지까지 되돌리기
3. 저장소로 커밋하기 ( soft reset )
-> 커밋만 되돌리기


>git reset --soft <되돌아갈 커밋>  
git reset --mixed <되돌아갈 커밋> 혹은 git reset (기본 값)  
git reset --hard <되돌아갈 커밋>   


기존 작업 내용(git log) 현재부터 되돌아간 커밋까지의 log가 삭제된다.
커밋 내용을 깔끔하게 유지하고 싶을 때 git reset 사용

<br>

작업 임시저장하기 (git stash)
----

git stash - 변경 사항 임시 저장  
git stash -m "<메세지>" - 변경 사항을 메세지와 함께 임시 저장  
git stash list - 임시저장한 리스트  
>stash@{0}: On master: stash test  

스택의 형식으로 되어있어 새로운 stash가 생길 경우 0번으로 할당된다.

>stash@{0}: On master: git stash test 2  
stash@{1}: On master: stash test

git stash apple <스태시 번호> - 임시 저장된 작업 적용하기  
git stash drop <스태시 번호> - 임시 저장된 작업 삭제하기

<br>

브랜치
----

master에서 가지가 뻗어나간다

>git branch <브랜치 이름> - 브랜치 생성  
git checkout -b <브랜치 이름> - 브랜치를 만들면서 체크아웃  
git checkout <브랜치 이름> - 작업영역을 해당 브랜치로 이동  
git merge <브랜치 이름> - 현재 위치하고있는 작업 영역에 브랜치의 작업내용을 합친다. ( 현재 영역이 기준이 되기떄문에 주의)  
git branch -d <브랜치 이름> - 브랜치 삭제 (다른곳에 체크아웃이 되어있어야 한다.)

fast-forward merge master브랜치에 아무런 작업이 없었던 경우에 merge 시 빠르게 병합이 시전된다.

<br>

충돌 해결하기
----

각 브랜치에서 동일 파일 건을 수정 할 때 발생
conflict가 발생 시 MERGING 상태로 남아있으며 충돌을 해결하고 재 커밋을 진행한다.

<br>

rebase
----

> git rebase <브랜치 이름> - 브랜치의 최신 커밋 버전으로 base를 변경한다


<br>













