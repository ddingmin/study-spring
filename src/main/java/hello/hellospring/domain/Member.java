package hello.hellospring.domain;

public class Member {
    // 고객이 정하는 id가 아니라 시스템이 정하는 임의의 값
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
