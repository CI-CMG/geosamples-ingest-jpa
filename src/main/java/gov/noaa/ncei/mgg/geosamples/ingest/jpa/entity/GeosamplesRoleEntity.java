package gov.noaa.ncei.mgg.geosamples.ingest.jpa.entity;

import edu.colorado.cires.cmg.jpa.model.EntityWithId;
import edu.colorado.cires.cmg.jpa.util.EntityUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "GEOSAMPLES_ROLE")
public class GeosamplesRoleEntity implements EntityWithId<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEOSAMPLES_ROLE_SEQ")
  @SequenceGenerator(name = "GEOSAMPLES_ROLE_SEQ", sequenceName = "GEOSAMPLES_ROLE_SEQ", allocationSize = 1)
  @Column(name = "ROLE_ID", nullable = false)
  private Long id;

  @Version
  @Column(name = "VERSION", nullable = false)
  private Long version;

  @Column(name = "ROLE_NAME", nullable = false, length = 200, unique = true)
  private String roleName;

  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<GeosamplesRoleAuthorityEntity> roleAuthorities = new ArrayList<>();

  public void addRoleAuthority(GeosamplesRoleAuthorityEntity roleAuthority) {
    EntityUtil.addAndParent(this, roleAuthorities, roleAuthority, this::removeRoleAuthority, roleAuthority::setRole);
  }

  public void removeRoleAuthority(GeosamplesRoleAuthorityEntity roleAuthority) {
    EntityUtil.removeAndOrphan(roleAuthorities, roleAuthority, roleAuthority::setRole);
  }

  public void clearRoleAuthorities() {
    EntityUtil.clearAndOrphan(roleAuthorities, GeosamplesRoleAuthorityEntity::setRole);
  }

  public List<GeosamplesRoleAuthorityEntity> getRoleAuthorities() {
    return roleAuthorities;
  }

  @Override
  public boolean equals(Object o) {
    return EntityUtil.equals(this, o);
  }

  @Override
  public int hashCode() {
    return EntityUtil.hashCodeGeneratedId();
  }

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getRoleName() {
    return roleName;
  }

  public String setRoleName(String roleName) {
    return this.roleName = roleName;
  }
}
