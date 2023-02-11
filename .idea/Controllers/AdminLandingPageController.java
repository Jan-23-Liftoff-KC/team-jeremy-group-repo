


@Controller
@RequestMapping("Users")
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "All Users");
        List Users = (List<User>) UserRepository.findAll();
        model.addAttribute("Users", Users );
        return "Users/index";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "Users/add";
    }
