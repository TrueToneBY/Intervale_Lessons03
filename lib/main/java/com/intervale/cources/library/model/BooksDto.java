package com.intervale.cources.library.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BooksDto extends Books {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 0, max = 20)
    private String isbn;

    @NotBlank
    @Size(min = 0, max = 20)
    private String name;

    @NotBlank
    @Size(min = 0, max = 20)
    private String author;

    @NotBlank
    @Size(min = 0, max = 20)
    private int pages;

    @NotBlank
    @Size(min = 0, max = 20)
    private double weight;

    @NotBlank
    @Size(min = 0, max = 20)
    private int price;

    public BooksDto() {
    }


    public @NotNull Integer getId() {
        return this.id;
    }

    public @NotBlank @Size(min = 0, max = 20) String getIsbn() {
        return this.isbn;
    }

    public @NotBlank @Size(min = 0, max = 20) String getName() {
        return this.name;
    }

    public @NotBlank @Size(min = 0, max = 20) String getAuthor() {
        return this.author;
    }

    public @NotBlank @Size(min = 0, max = 20) int getPages() {
        return this.pages;
    }

    public @NotBlank @Size(min = 0, max = 20) double getWeight() {
        return this.weight;
    }

    public @NotBlank @Size(min = 0, max = 20) int getPrice() {
        return this.price;
    }

    public void setId(@NotNull Integer id) {
        this.id = id;
    }

    public void setIsbn(@NotBlank @Size(min = 0, max = 20) String isbn) {
        this.isbn = isbn;
    }

    public void setName(@NotBlank @Size(min = 0, max = 20) String name) {
        this.name = name;
    }

    public void setAuthor(@NotBlank @Size(min = 0, max = 20) String author) {
        this.author = author;
    }

    public void setPages(@NotBlank @Size(min = 0, max = 20) int pages) {
        this.pages = pages;
    }

    public void setWeight(@NotBlank @Size(min = 0, max = 20) double weight) {
        this.weight = weight;
    }

    public void setPrice(@NotBlank @Size(min = 0, max = 20) int price) {
        this.price = price;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BooksDto)) return false;
        final BooksDto other = (BooksDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$isbn = this.getIsbn();
        final Object other$isbn = other.getIsbn();
        if (this$isbn == null ? other$isbn != null : !this$isbn.equals(other$isbn)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$author = this.getAuthor();
        final Object other$author = other.getAuthor();
        if (this$author == null ? other$author != null : !this$author.equals(other$author)) return false;
        if (this.getPages() != other.getPages()) return false;
        if (Double.compare(this.getWeight(), other.getWeight()) != 0) return false;
        if (this.getPrice() != other.getPrice()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BooksDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $isbn = this.getIsbn();
        result = result * PRIME + ($isbn == null ? 43 : $isbn.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $author = this.getAuthor();
        result = result * PRIME + ($author == null ? 43 : $author.hashCode());
        result = result * PRIME + this.getPages();
        final long $weight = Double.doubleToLongBits(this.getWeight());
        result = result * PRIME + (int) ($weight >>> 32 ^ $weight);
        result = result * PRIME + this.getPrice();
        return result;
    }

    public String toString() {
        return "BooksDto(id=" + this.getId() + ", isbn=" + this.getIsbn() + ", name=" + this.getName() + ", author=" + this.getAuthor() + ", pages=" + this.getPages() + ", weight=" + this.getWeight() + ", price=" + this.getPrice() + ")";
    }
}
