[#ftl]
<form action="/jmeno" method="get">
    <div class="row">
        <div class="ten columns">
            <label for="jmeno">Začátek křestního jména</label>
            <input id="jmeno" name="jmeno" class="u-full-width" type="search" value="${jmeno!}">
        </div>
        <div class="two columns submit">
            <button class="button-primary" type="submit">Zobrazit</button>
        </div>
    </div>
</form>
