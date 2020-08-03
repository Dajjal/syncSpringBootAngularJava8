package kz.factor.tofi.sync.model.users;

import kz.factor.tofi.sync.model.roles.AppRoles;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
@Data //ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor //ломбок аннотация: конструктор без аргуметов
public class AppUsers {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"/*,
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }*/
    )
    /*@GeneratedValue(generator = UUIDGenerator.generatorName)
    @GenericGenerator(name = UUIDGenerator.generatorName, strategy = "kz.factor.tofi.sync.util.UUIDGenerator")*/
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "app_user_roles",
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "app_role_id")
    )
    private Set<AppRoles> roles;
}
