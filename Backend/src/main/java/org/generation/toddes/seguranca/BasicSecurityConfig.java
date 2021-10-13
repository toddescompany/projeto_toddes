package org.generation.toddes.seguranca;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
}
