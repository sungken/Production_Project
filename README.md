#Production Management
커밋 규칙

출처: https://xtring-dev.tistory.com/entry/Git-규칙적인-Commit-메세지로-개발팀-협업하기-👾 [xtring.dev:티스토리]<br>
출처 : https://junhyunny.github.io/information/github/git-commit-message-rule/<br>

<커밋 메세지 구조><br>
$ <type>(<scope>): <subject>    -- 헤더<br>
  <BLANK LINE>                  -- 빈 줄
  <body>                        -- 본문<br>
  <BLANK LINE>                  -- 빈 줄<br>
  <footer>                      -- 바닥 글<br>

<type><br>
feat : 새로운 기능에 대한 커밋<br>
fix : build 빌드 관련 파일 수정에 대한 커밋<br>
build : 빌드 관련 파일 수정에 대한 커밋<br>
chore : 그 외 자잘한 수정에 대한 커밋(rlxk qusrud)<br>
ci : CI 관련 설정 수정에 대한 커밋<br>
docs : 문서 수정에 대한 커밋<br>
style : 코드 스타일 혹은 포맷 등에 관한 커밋<br>
refactor : 코드 리팩토링에 대한 커밋<br>
test : 테스트 코드 수정에 대한 커밋<br>


제목과 본문을 빈 행으로 구분합니다.<br>
제목을 50글자 이내로 제한합니다.<br>
제목의 첫 글자는 대문자로 작성합니다.<br>
제목의 끝에는 마침표를 넣지 않습니다.<br>
제목은 명령문으로! 과거형을 사용하지 않습니다.<br>
본문의 각 행은 72글자 내로 제한합니다.<br>
어떻게 보다는 무엇과 왜를 설명합니다.<br>


<footer><br>
선택 사항이므로 모든 커밋에 작성할 필요는 없습니다.<br>
이슈를 추적하기 위한 ID를 추가할 때 사용합니다.<br>
해결 - 해결한 이슈 ID<br>
관련 - 해당 커밋에 관련된 이슈 ID<br>
참고 - 참고할만한 이슈 ID<br>

해결: #123<br>
관련: #321<br>
참고: #222<br>

<예시><br>
Feat: 관심지역 알림 ON/OFF 기능 추가(#123)<br>

시군구의 알림을 각각 ON/OFF 할 수 있도록 기능을 추가함<br>
 
opnion0055: 구분 코드<br>

해결: close #123<br>
