package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
//@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";

    private @Inject EmployeeRepository repository;

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
////        System.out.println(id + " " + name);
//        return new Greeting(43, String.format(template, name));
//    }


    @RequestMapping("/greeting/{id}")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, @PathVariable Long id) {
        return new Greeting(id, String.format(template, name));
    }


//    @RequestMapping(method = RequestMethod.GET)
//    Iterable<Employee> readEmployees(@PathVariable String id) {
//        return this.repository.findAll();
//    }

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
//    }


}




//
//
//RestController
//@RequestMapping("/{userId}/bookmarks")
//class BookmarkRestController {
//
//    private final BookmarkRepository bookmarkRepository;
//
//    private final AccountRepository accountRepository;
//
//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
//        this.validateUser(userId);
//        return this.accountRepository
//                .findByUsername(userId)
//                .map(account -> {
//                    Bookmark result = bookmarkRepository.save(new Bookmark(account,
//                            input.uri, input.description));
//
//                    HttpHeaders httpHeaders = new HttpHeaders();
//                    httpHeaders.setLocation(ServletUriComponentsBuilder
//                            .fromCurrentRequest().path("/{id}")
//                            .buildAndExpand(result.getId()).toUri());
//                    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
//                }).get();
//
//    }
//
//    @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET)
//    Bookmark readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
//        this.validateUser(userId);
//        return this.bookmarkRepository.findOne(bookmarkId);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    Collection<Bookmark> readBookmarks(@PathVariable String userId) {
//        this.validateUser(userId);
//        return this.bookmarkRepository.findByAccountUsername(userId);
//    }
//
//    @Autowired
//    BookmarkRestController(BookmarkRepository bookmarkRepository,
//                           AccountRepository accountRepository) {
//        this.bookmarkRepository = bookmarkRepository;
//        this.accountRepository = accountRepository;
//    }
//
//    private void validateUser(String userId) {
//        this.accountRepository.findByUsername(userId).orElseThrow(
//                () -> new UserNotFoundException(userId));
//    }
//}