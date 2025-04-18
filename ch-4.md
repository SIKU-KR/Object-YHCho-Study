# Chapter 04. 설계 품질과 트레이드 오프

> 4장은 코드를 수정하면서 진행되어 필기 내용이 적다.

### 데이터 중심 설계는 객체의 행동보다는 상태에 초점을 맞춘다.

데이터 중심 설계를 하게되면 첫 질문이 **"이 객체가 포함해야하는 데이터가 무엇인가?"** 이다.
그러다보면 너무 이른 시기에 내부 구현에 초점을 맞추게 된다.

- 데이터 중심의 관점에서 객체는 단순한 데이터의 집합체일 뿐이다. **접근자와 수정자를 과도하게 추가**하게 되고 이 **데이터 객체를 사용하는 절차를 분리된 별도의 객체 안에 구현**하게 된다.
	- 접근자와 수정자는 `public`속성과 큰 차이가 없기 때문에 객체의 캡슐화는 완전히 무너질 수 밖에 없다.
- 데이터를 먼저 결정하고 데이터를 처리하는데 필요한 오퍼레이션을 나중에 결정하는 방식은 **데이터에 관한 지식이 객체의 인터페이스에 고스란히 드러나게 된다**. 
	- 이는 캡슐화의 실패로 이어지고 코드는 변경에 취약해진다.

> 결론적으로, 데이터 중심의 설계는 너무 이른 시기에 데이터에 대해 고민하기 떄문에 캡슐화에 실패하게 된다.

### 데이터 중심 설계는 객체를 고립시킨 채 오퍼레이션을 정의하게 만든다.

올바른 객체지향 설계의 무게 중심은 항상 객체의 내부가 아니라 외부에 맞춰져 있어야 한다.
중요한 객체가 다른 객체와 협력하는 방법이다. 

안타깝게도 데이터 중심 설계의 초점은 객체의 외부가 아니라 내부로 향한다. **실행 컨텍스트에 대한 깊이 있는 고민 없이 객체가 관리할 데이터의 세부 정보를 먼저 결정**한다.
**객체의 구현이 이미 결정된 상태**에서 다른 객체와의 협력 방법을 고민하기 때문에 **이미 구현된 객체의 인터페이스를 억지로 끼워맞출 수 밖에 없다**.