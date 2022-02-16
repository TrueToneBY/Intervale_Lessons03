package intervale.dz3.springbookdemo.model;

import org.springframework.web.client.RestTemplate;

public class Application {
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("https://openlibrary.org/isbn/9780140328721", Page.class);
        System.out.println("Name:    " + page.getName());
        System.out.println("About:   " + page.getAuthor());
        System.out.println("Phone:   " + page.getIsbn());
        System.out.println("Website: " + page.getId());
        System.out.println("About:   " + page.getPages());
        System.out.println("Phone:   " + page.getPrice());
        System.out.println("Website: " + page.getWeight());

    }
}
