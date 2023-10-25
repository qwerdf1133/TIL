# 마크다운

- markdown은 텍스트 기반 마크업 언어
- 2004년에 만들어짐.
- 깃헙 저장소 README.md 에서 접할수 있음.
- 별도의 도구 없이 텍스트로 작성
- 다양한 형태로 변환 가능
- 단점 : 표준이 없다.

## 문법


# Heading 1 <h1>
## Heading 2 <h2>
### Heading 3 <h3>
- 제목 등이나 문단 단위에 사용


Title
======

- 큰 제목

subTitle
------
- 작은 제목

#### h4
##### h5
###### h6까지 지원
####### h7부터는 지원하지 않는다.

## 인용구문

> 블록 인용
> > 인용 내부 인용
> > > Inner Inner

## 목록 (List)

- 순서가 있는 목록 Ordered List `<ol>`
    1. 1번  `<li>`
    2. 2번  
    3. 3번

- 순서가 없는 목록 Unorderd List `<li>`
    - 떡볶이
    - 오뎅
    - 만두
        + 순대
        + 양파
        - 쌈장
            * 돈가스
            * 자장면
            + 라면
    - 혼합해서 사용하는 것도 가능 (대쉬)
    + 혼합 (플러스)
    * 별표 (aterisks)

## 링크 연결 (HTML a 태그)
`[링크 할 내용](링크 주소)`
- [naver](https://naver.com)
- [Google](https://google.com)
- [Github](https://github.com)

## 이미지 삽입
`![대체 텍스트](이미지 주소)`
![플레이스홀더](https://via.placeholder.com/150)
![등대이미지-pixabay](https://cdn.pixabay.com/photo/2023/08/15/05/37/lighthouse-8191282_1280.jpg)

## 코드 강조하기
- 백틱(1왼쪽의 물결표시 있는 부분)으로 감싸면 코드 강조 `code`

- html 태그 사용
<pre><code>
print("hello, world!")
</code></pre>

- 백틱 3번 사용
```
print("hello, world!)
```

- 코드 하이라이트(언어 표시)
```python
print("hello, world!)
```
```js
console.log("hello, javascript!")
```
```java
public class Spring {
    public static void main(String[] args) {
        System.out.println("hello, Java")
    }
}
```

## 테이블 (표)
- `<table>` 태그
- 테이블 헤더를 구분하기 위해 3개 이상의 dash(-)가 필요
- 테이블 간격에 vertical bar(|)가 필요
- 헤더 구분셀에서 colon(:)으로 정렬 가능

| th테이블헤더 | th  | th  |
| --- | ---: | :---: |
| td테이블내용 | 오른쪽정렬  | 가운데정렬  |
| td테이블내용 | td  | td  |
| td테이블내용 | td  | td  |
| td테이블내용 | td  | td  |

- [마크다운 테이블 생성기](https://www.tablesgenerator.com/markdown_tables)


## 수평선 긋기 `<hr>`

<hr>

---
(dash * 3)
***
(asterisk * 3)
___
(underscore * 3)

## 줄바꾸기 `<br>`

- 줄바꿈<br>다음줄<br>다음줄
- 줄바꿈   공백    줄변경 안됨   표준에 따라 다름

## 강조 `<strong>`

- **강조**하기
- *이탤릭* 기울이기 `<i>`
- ~~취소선~~
- <u>밑줄</u>긋기