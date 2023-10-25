# 링크
- `ln <원본파일> <대상파일>` 기본값 하드링크
    - 하드링크 : 동일한 inode를 가리키는 링크 생성
        - 같은 원본 파일 데이터 블록을 사용
        - 허가권, 소유권, 파일크기 같음
- `ls -s <원본파일> <대상파일>`
    - 소프트링크 : 심볼릭 링크 (바로가기 개념) 경로를 가리키는 포인터   
        - 다른 데이터 블록을 사용(경로)
        - 파일크기가 경로명만큼 작다

# 패키지 설치 dpkg, apt
- 우분투 : 리눅스 데비앙 계열
    - 확장자가 deb 설치파일
    - debian package
- 설치
    - dpkg -i 패키지파일이름.deb
- 삭제
    - dpkg -r 패키지이름
- 조회
    - dpkg -l 패키지이름
    - dpkg --info 패키지파일이름.deb (파일정보)
- dpkg 단점 
    - 패키지 파일이 있어야 한다.
    - 의존성 문제가 있을 시 설치되지 않는다.
## apt
- 인터넷을 통해 다운로드와 의존성 문제를 해결해주는 패키지 관리자
- 설치
    - apt install 패키지명
- 패키지 목록 업데이트
    - apt update
- 삭제
    - apt remove 패키지이름
    - apt purge 패키지이름 (+설정파일 제거)
    - apt autoremove (자동 사용하지 않는 패키지 제거)
- apt-chace
    - 패키지 정보 보기
        - apt-cache show 패키지이름
    - 의존성 정보보기
        - apt-cache depends 패키지이름
    - 역의존성 정보보기
        - apt-cache rdepends 패키지이름
- apt 업그레이드
    - apt upgrade (패키지 목록 업데이트 apt dupate 후 실행)
    - 업그레이드는 이전 버전보다 최신버전을 설치

# 압축 파일과 묶기
    - gz, xz, bz2(bzip2), zip 등을 사용한다
    - xz
        - xz 파일명         // 파일 압축됨.  .xz 기존 파일 삭제
        - xz -d 파일명.xz   // 압축 해제. (decompress),압축파일 삭제
        - xz -k 파일명      // 기존 파일 유지하며 압축
    - bz2
        - bzip2 파일명         // 파일 압축됨. .bz2 기존 파일 삭제
        - bzip2 -d 파일명.xz   // 압축 해제. (decompress),압축파일 삭제
        - bzip2 -k 파일명      // 기존 파일 유지하며 압축
    - gz
        - gz 파일명         // 파일 압축됨. .gz 기존 파일 삭제
        - gz -d 파일명.xz   // 압축 해제. (decompress),압축파일 삭제
        - gz -k 파일명      // 기존 파일 유지하며 압축
    - zip (윈도우와 호환을 위해 사용)
        - zip 생성될파일명.zip 압축할 파일명 // 파일 압축 : 기존 파일 유지
        - unzip 압축파일명.zip              // 압축 해제 : 기존 파일 유지

## tar 파일 묶기
    - [ 동작 ]
        - 리눅스에서는 원칙적으로 '파일 묶기'와 '파일 압축'이 별개로 실행
        - c : 새로운 묶음
        - x : 묶음 해제
    - [ 옵션 ]
        - C : 지정된 디렉토리에 압축묶음 풀기 
        - f : 파일로 묶음, 필수옵션 (기본값은 테이프)
        - v : 묶거나 푸는 과정을 보여줌
        - j : bzip2
        - J : xz
        - z : gz

## 파일 위치 검색
- find
    - 옵션
        - name (파일명 검색)
        - user (소유자)
        - perm (허가권)
        - size (파일크기)

- which (패키지명) : 경로에 설정된 디렉토리 검색
- whereis 패키지명 : 실행파일, 메뉴얼 위치 검색 

# cron
- 주기적으로 반복되는 일을 자동으로 실행할 수 있도록 시스템 작업 예약
- /etc/crontab
- 매 분 무슨 명령을 실행해
- * * * * * root(사용자이름) /root/myBackup.sh(스크립트)
- 분 / 시 / 일 / 월 / 요일 / 사용자 / 실행명령 
- shell Script 사용시 실행 퍼미션(허가권)을 줘야한다.
    - chmod 755 (파일명)
- crontab 파일 수정 후
- systemctl restart cron (크론을 재시작)
    * timedatectl set-ntp 0 (시간을 수동으로 변경할 수 있게 해줌)
    * date 011503002030 (1월 15일 3시 2023년으로 시간 변경)
    * rdate time.bora.net (타임서버에서 정확한 시간으로 변경)
        - apt install rdate

# at
- 일회성 예약 명령어 : 한번 실행 후 소멸
- at 시간 
    - at 3:00am tommorow -> 내일 새벽 3시
    - at 11:00pm January 30 -> 1월 30일 오후 11시
    - at now +1 hours -> 지금으로부터 한시간 후
- 스크립트 명령어 입력하고
- 종료할 때 ctrl + D
- 예약 확인 리스트 (작업번호 확인 가능)
    - at -1
- 취소 atrm 작업번호
