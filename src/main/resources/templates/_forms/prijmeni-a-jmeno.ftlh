[#ftl]
<form action="/prijmeni-a-jmeno" method="get">
    <div class="row">
        <div class="ten columns">
            <label for="jmeno">Začátek křestního jména</label>
            <input id="jmeno" name="jmeno" class="u-full-width" type="search" value="${jmeno!}">
        </div>
        <div class="ten columns">
            <label for="prijmeni">Začátek příjmení</label>
            <input id="prijmeni" name="prijmeni" class="u-full-width" type="search" value="${prijmeni!}">
        </div>
        <div class="two columns submit">
            <button class="button-primary" type="submit">Zobrazit</button>
        </div>
    </div>
</form>
