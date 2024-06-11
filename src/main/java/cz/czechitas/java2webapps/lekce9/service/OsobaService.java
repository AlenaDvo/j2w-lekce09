package cz.czechitas.java2webapps.lekce9.service;

import cz.czechitas.java2webapps.lekce9.entity.Osoba;
import cz.czechitas.java2webapps.lekce9.form.RokNarozeniForm;
import cz.czechitas.java2webapps.lekce9.repository.OsobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Služba pro práci s osobami a adresami.
 */
@Service
public class OsobaService {
    private final OsobaRepository osobaRepository;

    @Autowired
    public OsobaService(OsobaRepository osobaRepository) {
        this.osobaRepository = osobaRepository;
    }

    /**
     * Vrací stránkovaný seznam všech osob v databázi seřazených podle příjmení a jména.
     */
    public Page<Osoba> seznamOsob(Pageable pageable) {
        return osobaRepository.findAll(pageable);
    }

    /**
     * Vrací stránkovaný seznam všech osob v databázi, které se narodili mezi uvedenými roky.
     */
    public Page<Osoba> seznamDleRokuNarozeni(RokNarozeniForm form, Pageable pageable) {
        return osobaRepository.findByRok(form.getOd(), form.getDo(), pageable);
    }

    /**
     * Vrací stránkovaný seznam osob podle začátku příjmení.
     */
    public Page<Osoba> seznamDleZacatkuPrijmeni(String zacatekPrijmeni, Pageable pageable) {
        return osobaRepository.findByPrijmeniStartingWithIgnoreCase(zacatekPrijmeni, pageable);
    }

    /**
     * Vrací stránkovaný seznam osob podle začátku křestního jména.
     */
    public Page<Osoba> seznamDleZacatkuKrestnihoJmena(String zacatekJmena, Pageable pageable) {
        return osobaRepository.findByJmenoStartingWithIgnoreCase(zacatekJmena, pageable);
    }

    /**
     * Vrací stránkovaný seznam osob podle obce.
     */
    public Page<Osoba> seznamDleObce(String obec, Pageable pageable) {
        return osobaRepository.findOsobaByAdresa_Obec(obec, pageable);
    }

    /**
     * Vrací stránkovaný seznam osob narozených před x lety.
     */
    public Page<Osoba> seznamDleVeku(int vek, Pageable pageable) {
        LocalDate datumNarozeni = LocalDate.now().minusYears(vek);
        return osobaRepository.findByDatumNarozeniBefore(datumNarozeni, pageable);
    }

    /**
     * Vrací stránkovaný seznam osob, jejichž příjmení začíná na uvedený první text a křestní jméno začíná na uvedený druhý text.
     */
    public Page<Osoba> seznamDlePrijmeniAJmena(String zacatekPrijmeni, String zacatekJmena, Pageable pageable) {
        return osobaRepository.findByPrijmeniAJmeno(zacatekPrijmeni, zacatekJmena, pageable);
//        return osobaRepository.findOsobaByPrijmeniStartingWithAndJmenoStartingWithIgnoreCase(zacatekPrijmeni, zacatekJmena, pageable);
    }
}
