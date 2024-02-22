 %p  debug, info, warn, error, fatal 등의 priority 가 출력된다.
	 %m  로그내용이 출력됩니다
	 %d  로깅 이벤트가 발생한 시간을 기록합니다.
	   포맷은 %d{HH:mm:ss, SSS}, %d{yyyy MMM dd HH:mm:ss, SSS}같은 형태로 사용하며 SimpleDateFormat에 따른 포맷팅을 하면 된다
	 %t  로그이벤트가 발생된 쓰레드의 이름을 출력합니다.
	 %%  % 표시를 출력하기 위해 사용한다.
	 %n  플랫폼 종속적인 개행문자가 출력된다. rn 또는 n 일것이다.
	 %c  카테고리를 표시합니다
	   예) 카테고리가 a.b.c 처럼 되어있다면 %c{2}는 b.c가 출력됩니다.
	 %C  클래스명을 포시합니다.
	   예)클래스구조가 org.apache.xyz.SomeClass 처럼 되어있다면 %C{2}는 xyz.SomeClass 가 출력됩니다
	 %F  로깅이 발생한 프로그램 파일명을 나타냅니다.
	 %l  로깅이 발생한 caller의 정보를 나타냅니다 - 호출자
	 %L  로깅이 발생한 caller의 라인수를 나타냅니다 - 호출자
	 %M  로깅이 발생한 method 이름을 나타냅니다.
	 %r  어플리케이션 시작 이후 부터 로깅이 발생한 시점의 시간(milliseconds)
	 %x  로깅이 발생한 thread와 관련된 NDC(nested diagnostic context)를 출력합니다.
	 %X  로깅이 발생한 thread와 관련된 MDC(mapped diagnostic context)를 출력합니다.
	 %5p : 우측 정렬로 로그 레벨을 남김. 로그레벨이 5글자가 안되면 왼쪽에 공백을 추가하여 5글자 맞춤.
	 %-5p : 좌측 정렬.
