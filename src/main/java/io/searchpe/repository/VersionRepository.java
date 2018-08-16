package io.searchpe.repository;

import io.searchpe.model.Version;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface VersionRepository {

    Optional<Version> getLastVersion();

    Optional<Version> getLastCompletedVersion();

    List<Version> getCompleteVersionsBefore(Date date);

    List<Version> getVersionsByParameters(Map<String, Object> parameters);

    boolean deleteVersion(Version version);

}
