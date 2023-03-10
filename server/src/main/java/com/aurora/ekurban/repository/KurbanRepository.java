package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.enumeration.KurbanCins;
import com.aurora.ekurban.enumeration.KurbanDurum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface KurbanRepository extends JpaRepository<Kurban, Long>, JpaSpecificationExecutor<Kurban> {
    List<Kurban> findAllByCins(KurbanCins cins);
    List<Kurban> findAllByDurum(KurbanDurum durum);
    List<Kurban> findAllByCinsAndDurum(KurbanCins cins, KurbanDurum durum);
}
