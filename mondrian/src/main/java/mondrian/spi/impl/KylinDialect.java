package mondrian.spi.impl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Implementation of {@link mondrian.spi.Dialect} for Kylin.
 *
 * @author Sebastien Jelsch
 * @since Jun 08, 2015
 */
public class KylinDialect extends JdbcDialectImpl {

    public static final JdbcDialectFactory FACTORY =
            new JdbcDialectFactory(KylinDialect.class, DatabaseProduct.KYLIN) {
                protected boolean acceptsConnection(Connection connection) {
                    return super.acceptsConnection(connection);
                }
            };

    /**
     * Creates a KylinDialect.
     *
     * @param connection Connection
     * @throws SQLException on error
     */
    public KylinDialect(Connection connection) throws SQLException {
        super(connection);
    }

    @Override
    public boolean allowsCountDistinct() {
        return false;
    }

    @Override
    public boolean allowsJoinOn() {
        return true;
    }
}