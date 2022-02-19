package intervale.dz3.springbookdemo.openlibrary.exceptiom;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

public class OpenLibraryErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus.Series statusCode = response.getStatusCode().series();
        return statusCode == HttpStatus.Series.CLIENT_ERROR || statusCode == HttpStatus.Series.SERVER_ERROR;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError()) {
            throw new OpenLibraryException("Unable to complete request to Open Library. Bad request.");
        } else if (response.getStatusCode().is5xxServerError()) {
            throw new OpenLibraryException("Failed to get response from Open Library. Try again later.");
        }

    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError()) {
            throw new OpenLibraryException("Unable to complete request to Open Library with method " + method + " and URL " + url.getPath() + ". Bad request.");
        } else if (response.getStatusCode().is5xxServerError()) {
            throw new OpenLibraryException("Failed to get response from Open Library. Try again later.");
        }
    }
}
