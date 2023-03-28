package kjyyjk920.springboot.domain.posts;


import kjyyjk920.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    //id 애노테이션은 해당 테이블의 pk필드. 중복x 널값x. 행을 식별할 수 있는.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //해당  @Entity 클래스의 필드는 자동으로 칼럼이 된다.
    //@Column 사용 이유 : 변경이 필요한 경우

    //VARCHAR의 사이즈를 500으로 늘리려고 @Column
    @Column(length = 500, nullable = false)
    private String title;

    //TEXT로 타입 변경하려고
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
