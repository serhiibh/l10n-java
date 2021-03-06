package ws.l10n.core;

/**
 * Interface describes main L10n APIs functionality
 *
 * In case of error or exceptions throws runtime {@link ServiceException}.
 *
 * @author Serhii Bohutskyi
 */
public interface MessageBundleService {

    /**
     * Loads messages and put them to {@link MessageBundle} object.
     *
     * @param bundleKey key of bundle
     * @param version   version string
     * @return {@link MessageBundle}
     */
    MessageBundle load(String bundleKey, String version);

    /**
     * The same as above only loads requested locales.
     *
     * @param bundleKey key of bundle
     * @param version   version string
     * @param locales   requested locales
     * @return {@link MessageBundle}
     */
    MessageBundle load(String bundleKey, String version, String[] locales);

}
