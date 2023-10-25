🙄Git 배우기
===

GitHub
---
### Github 가입
- [Github 홈페이지](https://github.com/)에서 회원 가입
- 새로운 Repository(원격 저장소) 만들기
    - Owener : 사용자이름
    - Repository name : 중복되지 않는 저장소 이름
    - Description : 저장소를 설명하는 요약 한 줄
    - Public / Private : 공개 / 비공개 설정
    - Add a README : 리드미 파일을 자동으로 추가 (체크 비권장)  (이후 추가 가능)
    - Add .gitignore : 깃 저장소에 올리면 안 되는 파일의 목록이 담긴 파일 (해당 파일들은 무시) 추가하기 (프로그래밍 언어별 기본값) (이후 추가 가능)
    - Choose a license : 오픈소스에 대한 지적 재산권을 부여하기 위한 파일 추가 (이후 추가 가능)
    - 3가지 파일을 선택하지 않으면, Quick Setup (CLI 명렁어)를 볼 수 있다.

Git
---

1. 깃 저장소 **만들기(초기화)** 명령어

    ` git init`

2. 깃 추적되지 않은 파일 모두 현재 폴더 기준으로 **스테이징** 

     `git add .`

3. **커밋**하기

    `git commit -m "커밋 메시지"`

4. **원격저장소 추가**하기

    `git remote add origin https://github.com/expandsource-wed/blank.git`

    - `git remote add [원격저장소 이름] [원격저장소 주소]`


5. 메인 **브랜치**로 변경하기
    - (2020년도부터 깃허브 기본 브랜치 master -> main으로 변경됨)

    `git branch -M main`

6. 원격 저장소에 업로드하기(push)

    `git push -u origin main`

    `git push [원격저장소 이름] [원격저장소 브랜치]`

- 기본 원격저장소의 이름은 'origin' 기본 브랜치의 이름은 'main'이다.

### 용어 정리
- Git(깃) : VCS (Version Control System) 버전 관리 시스템
- GitHub : Git으로 관리하는 프로젝트를 원격으로 공유하는 사이트
- GUI : Graphic User Interface, 마우스로 화면을 클릭해서 사용하는 방식
- CLI : Command Line Interface, 명령어를 하나씩 입력해서 사용하는 방식
- commit : 버전 관리를 통해 생성된 파일, 또는 행위
- log : 지금까지 만든 커밋을 모두 확인
- 로컬 저장소 : 내 컴퓨터 안의 Git 프로젝트
- 원격 저장소 : GitHub에 업로드 된 Git 프로젝트
- push : 로컬저장소 -> 원격저장소로 올리는 것
- pull : 원격저장소 -> 로컬저장소로 내려받는 것

### Github 토큰 만들기
- Github에서 2021년 8월부터 비밀번호 대신 Token을 사용하도록 업데이트(보안문제)
- 깃헙 프로필(우측상단) > Developer Settings > 왼쪽 메뉴 최하단 스크롤 > Personal access token > Genereate new token(classic)
- 기한, 권한(scope) 선택
- 생성된 토큰은 더이상 보여지지 않으므로 중요한 곳에 저장

### 소스트리에서 토큰 적용하기
- 최상단 메뉴 [도구] => [옵션] => [인증]
- 계정선택 => 편집 => 인증 : Personal Access Token 선택 후 복사한 토큰 붙여넣기

### Git 저장방식 알아보기
- Git의 저장방식 SNAPSHOT
    - 변경된 파일을 통째로 저장
- 차이점만 저장하는 방식 : delta
- 순서
    1. 변경된 파일을 저장한다. (save)
    2. 스테이지로 올라간다. (git add)
    3. 스테이지의 스냅샷을 찍는다. (git commit)
    4. 원격저장소 업데이트 (git push)

- 깃으로 관리하는 파일의 4가지 상태
    - 추적안된 상태 (untracked)
    - 추적된 상태 (tracked)
        1. 수정 없음 (unmodified)
        2. 수정 함 (modified)
        3. 스테이지 됨(staged)

    - 예시
        - 새로운 파일을 만들었을 때
            - untracked(추적안된 상태)
        - add를 통해 스테이징
            - untracked -> staged
                                  - 추적안됨 -> 스테이징(애딩)
        - commit을 통해 snapshot
            - staged -> unmodified
            - 스테이징 -> 수정없음
        - 한번 add가 된 상태에서 파일 내용이 변경된 경우
            - unmodified -> modified


    ## 브랜치 (branch)

    - 여러 명의 개발자가 동시에 개발을 할 때 (협업)
    - 새로운 Branch를 추가
    - 브랜치는 커밋을 가리킨다(브랜치 -> 커밋)
    - 저장소의 병렬된 버전
    - 메인 분기, 기본 분기에 영향을 주지 않고 자유롭게 작업 가능
    - 원하는 작업일 때 다시 갈라진 브랜치(분기)를 기본 브랜치에 병합
    
 ## 병합 (Merge)

 . 두 버전의 합집합을 구하는 것
    1. merge commit : 병합 커밋
        - 각각 다른 내용이 충돌없이 합쳐지는 것
    2. fast-foward : 빨리 감기
        - 상태를 새로만들 필요 없이 포인터만 변경하는 것
    3. conflict : 병합 충돌
        - 같은 파일, 같은줄을 각각 다른 커밋이 수정하였을 때
        - 충돌의 경우 수동으로 병합 conflict를 해결해야 함.

- base 브랜치를 기준으로 compare 브랜치를 병합한다.
- 충돌 병합 해결하기
    - 충돌이 일어난 파일을 열어보면 
```
<<<<<< HEAD
충돌 내용 1
===========
충돌 내용 2
>>>>>> compare
```
    - 필요없는 내용들을 삭제하고, 수동으로 파일을 편집 한 후 저장
    - 충돌이 해결된 파일을 스테이징(add)하고 커밋
    - 커밋 메시지가 자동으로 채워짐. (Merge ...)
- vs Code 충돌해결 기능
    - Accept Curent Change (베이스 브랜치의 내용만 남김)
    - Accept Incoming Change (compare 브랜치의 내용만 남김)
    - Accept Both Change (둘 다 남김)
    
# Pull Request
- 공동 작업자에게 브랜치 병합을 요청하는 메시지를 보내는 것
- 원격 저장소에서 최근 베이스 브랜치보다 앞선 브랜치의 원격 커미시 있을 경우
    - Compare & pull request    버튼 확인 가능
- 협업자에게 정중하게 병합을 요청한다.
    - base : 병합된 커밋이 들어갈 브랜치
    - compare : 병합이 될 브랜치
    - Able to Merge : 충돌 없이 병합될 수 있음.
    - 제목과 내용 부분에 협업자에게 도움이 되는 설명을 남긴다.
- 원격저장소에서 변경이 된 내용을 로컬에서 확인하기
    - git fetch : 원격저장소의 내용을 업데이트
    - git pull : 로컬로 가져와서 합치기
    
    
    # Tag
    - 개발이 완료되고 출시하게 될 때 => Release 
    - 버전 정보를 Tag를 통해 표시할 수 있다.
    - Tag => 특정 커밋을 가리킨다.
    - 특정 커밋을 기준으로 [태그 추가]
    - 버전 관리
        - major 업그레이드 : 사용자들이 느끼는 큰 변화가 있는 경우
        - minor 업그레이드 : 작은 변화가 있는 경우
        - 유지보수 업그레이드 : 버그 수정, 유지보수 등의 변화
        - v1(major).0(minor).0(maintence)
    - Tag를 원격저장소에 Push 하면
    - 깃허브 저장소에서 Realease 버전 정보를 확인 가능하다.

# fork : 원격저장소 복사해서 새로운 원격 저장소 만들기

- 원본 저장소에 직접 푸시를 할 수 있는 사람은 소유자
- 외 협력자(collaborator)로 등록되어야 함.
- 깃허브 저장소 'Setting' - 'Collaborator' => 'Add People'
- 에서 깃허브 계정(email 또는 username으로 검색하여 추가)

- 원본 저장소 소유자 입장에서 협력자가 많아질 수록
- 저장소 관리가 힘들어진다.
- 오픈 소스에 참여(기여)하고 싶은 개발자에게 
- 원본 저장소를 fork 하게 해서 
- fork한 저장소에서 commit 을 하여 원본 소유자에게
- contribute -> pull request를 통해
- 원본 저장소에 파일을 추가할 수 있다.

- branch : 하나의 원격 저장소에서 분기점을 나눔
- fork : 여러 원격 저장소에서 분기를 나눔

# 원격 저장소 원본 추가
- 'git remote add upstream [원격저장소 원본주소]'
- 설정 - 원격 - 추가
- 원격이름 : upstream 
- URL ; `원격 저장소 주소`

- upstream : 원본 저장소를 지칭하는 관용적 이름
- 추가는 원본 저장소에서 우클릭[원본 저장소 가져오기]
- git fetch - 원본 저장소 이력이 업데이트 (새로고침)


# Rebase (재배치)
- 오래된 커밋을, 새 커밋으로 이력을 조작
- 브랜치에서 다른 베이스로 변경 내용을 다시 적용하고,
- 해당 분가의 HEAD로 결과를 재설정 합니다.

- (소스트리) 병합할 커밋 우클릭 -> 재배치(rebase)

- 충돌이 있다면, rebase 도중 충돌파일을 수정하고, 
- rebase를 계속한다.

- (소스트리) 액션 > 재배치 계속

- 원격 저장소에 push를 할때는 커밋 이력이 조작되었기 때문에
- 강제 푸시를 해야 한다.

- 도구 -> 옵션 -> Git -> 강제 푸시 가능 Check 
