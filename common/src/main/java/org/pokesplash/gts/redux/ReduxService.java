package org.pokesplash.gts.redux;

import com.devkka.reduxeconomy.api.EconomyService;
import com.devkka.reduxeconomy.economy.DefaultEconomyService;
import kotlin.ULongKt;
import org.pokesplash.gts.api.economy.GtsEconomy;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Class to interact with the Impactor API
 */
public class ReduxService implements GtsEconomy {

	private final EconomyService service = EconomyService.instance();

	/**
	 * Method to get the account of a player.
	 * @param uuid The UUID of the player.
	 * @return The account of the player.
	 */


	/**
	 * Method to add to the balance of an account.
	 * @param account The account to add the balance to.
	 * @param amount The amount to add.
	 * @return true if the transaction was successful.
	 */
	@Override
	public boolean add(UUID account, double amount) {

		return service.deposit(account, (long) amount);
	}

	/**
	 * Method to remove a balance from an account.
	 * @param account The account to remove the balance from.
	 * @param amount The amount to remove from the account.
	 * @return true if the transaction was successful.
	 */
	@Override
	public boolean remove(UUID account, double amount) {

		return service.withDraw(account, (long) amount);
	}

	@Override
	public double balance(UUID player) {
		return (double) service.getBalance(player);
	}
}
