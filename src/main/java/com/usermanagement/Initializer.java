package com.usermanagement;

import com.usermanagement.model.Privilege;
import com.usermanagement.model.Role;
import com.usermanagement.model.User;
import com.usermanagement.model.enums.Privileges;
import com.usermanagement.model.enums.Roles;
import com.usermanagement.repository.PrivilegeRepository;
import com.usermanagement.repository.RoleRepository;
import com.usermanagement.model.requests.CreateTeamRequest;
import com.usermanagement.model.requests.CreateUserRequest;
import com.usermanagement.service.TeamService;
import com.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final UserService userService;
    private final TeamService teamService;

    private final PrivilegeRepository privilegeRepository;
    private final RoleRepository roleRepository;

    @Override
   public void run(String... args) throws Exception {
/*
       // Init User
        User dali = createUser("dali", "dali", "dali", "1234", "dali@gmail.com");
        User hama = createUser("hama", "hama", "hama", "1234", "hama@gmail.com");
*/
        // Create Roles and Privileges
        Privilege teamMemberPrivilege = createPrivilege(Privileges.MEMBER);
        Privilege teamAdminPrivilege = createPrivilege(Privileges.ADMIN);

        List<Privilege> adminPrivileges = Arrays.asList(teamMemberPrivilege, teamAdminPrivilege);

        // Admin has the Admin and the Member Privilege
        Role adminRole = createRole(Roles.ADMIN, adminPrivileges);

        // Member only has the MemberPrivilege
        Role memberRole = createRole(Roles.MEMBER, List.of(teamMemberPrivilege));

      /*  // Init Team
        CreateTeamRequest createManu = CreateTeamRequest.builder()
                .name("Manu FC")
                .build();

        teamService.create(createManu, dali);

        CreateTeamRequest createChelsea = CreateTeamRequest.builder()
                .name("Chelsea")
                .build();

        teamService.create(createChelsea, hama);
*/


    }

    private User createUser(String username, String firstname, String lastname, String password, String email) {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .username(username)
                .firstname(firstname)
                .lastname(lastname)
                .password(password)
                .email(email)
                .build();
        return this.userService.create(createUserRequest);
    }

    private @NotNull Privilege createPrivilege(Privileges privilege) {
        Privilege p = new Privilege();
        p.setPrivilege(privilege);
        return privilegeRepository.save(p);
    }

    private Role createRole(Roles role, List<Privilege> privilegesList) {
        Role r = new Role();
        r.setRole(role);
        r.setPrivileges(privilegesList);
        return roleRepository.save(r);
    }
}