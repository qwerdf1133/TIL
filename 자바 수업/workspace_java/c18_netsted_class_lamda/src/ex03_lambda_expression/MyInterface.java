package ex03_lambda_expression;

// 하나의 기능을 정의하는 interface : 함수형 인터페이스
@FunctionalInterface // 함수형 인터페이스인지 검증하는 어노테이션
public interface MyInterface {
	void method();
}
